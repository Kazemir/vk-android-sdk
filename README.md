About this fork
==========
To connect this library with your project, go to https://jitpack.io/#DiXL0f0S/vk-android-sdk/ and select latest release

vk-android-sdk
==========

Library for working with VK API, authorization through VK app, using VK functions. Minimal version of Android is 2.3

Prepare for Using VK SDK
----------
To use VK SDK primarily you need to create a new VK application  **[here](https://vk.com/editapp?act=create)** by choosing the Standalone application type. Choose a title and confirm the action via SMS and you will be redirected to the application settings page.
You will require your Application ID (referenced as API_ID in the documentation). Fill in the "Batch name for Android", "Main Activity for Android" and "Certificate fingerprint for Android". 

Certificate Fingerprint Receiving
==========
To receive your certificate's fingerprint you can use one of the following methods.

Fingerprint Receiving via Keytool
----------
1) You need to find the keystore location for your app. The ''debug'' store is usually located in these directories:
* ~/.android/ for OS X and Linux, 
* C:\Documents and Settings\<user>\.android\ for Windows XP, 
* C:\Users\<user>\.android\ for Windows Vista, Windows 7 and Windows 8.

The keystore for the release version is usually created by a programmer, so you should create it or recall its location. 

2) After the keystore's location has been found, use keytool utilite (it is supplied with the Java SDK). You can get keys list with the following command:
<blockquote>keytool -exportcert -alias androiddebugkey -keystore path-to-debug-or-production-keystore -list -v</blockquote>
You will observe a similar result:
<blockquote>Certificate fingerprint: SHA1: DA:39:A3:EE:5E:6B:4B:0D:32:55:BF:EF:95:60:18:90:AF:D8:07:09</blockquote>
By deleting all the colons you'll get your key's fingerprint.

Fingerprint Receiveing via SDK
----------
If you've already added SDK to your project, you can use the following function in each Activity of your app.

```
String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
```

As a rule, fingerprints contains a single line. It's a fingerprint of your certificate (depends on the certificate used for your app's signing)

<blockquote>You can add more than one fingerprint in your app settings, e.g., debug and release fingerprints.</blockquote>

Editing AndroidManifest.xml
----------
Your need to add to your manifest the following elements:

1) in the root of <manifest> you need to add permission <uses-permission android:name="android.permission.INTERNET" />

2) in the <application> element shoud be added

```
<activity android:name="com.vk.sdk.VKServiceActivity" android:label="ServiceActivity" android:theme="@style/VK.Transparent" />
```

to avoid possible problems with running authorizing activity.


Using SDK
==========

SDK Initialization
----------

1) Add this to the resource file (example strings.xml):

```
<integer name="com_vk_sdk_AppId">your_app_id</integer>
```

2) Initialize the SDK on startup using the following method. The best way is to call it in the app's onCreate method.
`VKSdk.initialize(Context applicationContext);`

User Authorization
----------
There are several authorization methods:

```
VKSdk.login(Activity runningActivity, String... scope);
VkSdk.login(Fragment runningFragment, String... scope);
```

When succeeded call the onActivityResultMethod:

```
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
        @Override
        public void onResult(VKAccessToken res) {
            startTestActivity();
            // User passed Authorization
        }
        @Override
        public void onError(VKError error) {
            // User didn't pass Authorization
        }
    })) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
```

Handling "AccessToken invalid"
----------

Use AccessTokenTracker the following way:


```
public class Application extends android.app.Application {
    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                // VKAccessToken is invalid
            }
        }
    };
    @Override
    public void onCreate() {
        super.onCreate();
        vkAccessTokenTracker.startTracking();
        VKSdk.initialize(this);
    }
}
```

API Requests
==========

Requests Syntax
----------
1) Plain request.
`VKRequest request = VKApi.users().get();`

2) Request with parameters.
`VKRequest request = VKApi.users().get(VKParameters.from(VKApiConst.USER_IDS, "1,2"));`
```

3) Request with predetermined maximum number of attempts.
```
VKRequest request = VKApi.wall().post(VKParameters.from(VKApiConst.OWNER_ID, "-60479154", VKApiConst.MESSAGE, "Hello, world!"));
request.attempts = 10;
//or infinite
//postReq.attempts = 0;
```
It will take 10 attempts until succeeds or an API error occurs. 

4) Request that calls a method of VK API.
`VKRequest request = new VKRequest("friends.get", VKParameters.from(VKApiConst.FIELDS, "sex,bdate,city"));`

5) Request for uploading photos on user wall.
```
final Bitmap photo = getPhoto();
VKRequest request = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo, VKImageParameters.jpgImage(0.9f)), 0, 60479154);
```

Requests Sending
----------
```
request.executeWithListener(new VKRequestListener() {
    @Override
    public void onComplete(VKResponse response) {
        //Do complete stuff
    }
    @Override
    public void onError(VKError error) {
        //Do error stuff
    }
    @Override
    public void onProgress(VKRequest.VKProgressType progressType,
                                     long bytesLoaded,
                                     long bytesTotal)
    {
        //I don't really believe in progress
    }
    @Override
    public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
        //More luck next time
    }
});
```

Batch Processing Requests
----------
SDK gives a feature to execute several unrelated requests at the one call. 
1) Prepare requests.
                    
```
VKRequest request1 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo1, VKImageParameters.jpgImage(0.9f)), 0, 60479154);
VKRequest request2 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo2, VKImageParameters.jpgImage(0.5f)), 0, 60479154);
VKRequest request3 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo3, VKImageParameters.jpgImage(0.1f)), 0, 60479154);
VKRequest request4 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo4, VKImageParameters.pngImage()), 0, 60479154);
```

2)  Combine created requests into one. 
`VKBatchRequest batch = new VKBatchRequest(request1, request2, request3, request4);`

3) Load the obtained request.

```
batch.executeWithListener(new VKBatchRequestListener() {
    @Override
    public void onComplete(VKResponse[] responses) {
        super.onComplete(responses);
        String[] photos = new String[responses.length];
        for (int i = 0; i < responses.length; i++) {
            VKPhoto photoModel = ((VKPhotoArray) responses[i].parsedModel).get(0);
            photos[i] = String.format("photo%s_%s", photoModel.owner_id, photoModel.id);
        }
        makePost(VKStringJoiner.join(photos, ","));
    }
    @Override
    public void onError(VKError error) {
        showError(error);
    }
});
```

4) The result of each method returns to a corresponding requestListener. The **batch** VKResponse for each request in order they have been passed.

[See the full classes reference at GitHub pages](http://vkcom.github.io/vk-android-sdk/)
