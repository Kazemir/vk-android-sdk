package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKUsersArray;

/**
 * Builds requests for API.account part
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class VKApiAccount extends VKApiBase {

    /*
     * https://vk.com/dev/account.banUser
     */
    public VKRequest banUser(VKParameters params) {
        return prepareRequest("banUser", params);
    }

    /*
     * https://vk.com/dev/account.changePassword
     */
    public VKRequest changePassword(VKParameters params) {
        return prepareRequest("changePassword", params);
    }

    /*
     * https://vk.com/dev/account.getAppPermissions
     */
    public VKRequest getAppPermissions(VKParameters params) {
        return prepareRequest("getAppPermissions", params);
    }

    /*
     * https://vk.com/dev/account.getBanned
     */
    public VKRequest getBanned() {
        return getBanned(null);
    }

    /*
     * https://vk.com/dev/account.getBanned
     */
    public VKRequest getBanned(VKParameters params) {
        return prepareRequest("getBanned", params, VKUsersArray.class);
    }

    /*
 * https://vk.com/dev/account.getCounters
 */
    public VKRequest getCounters() {
        return getCounters(null);
    }

    /*
     * https://vk.com/dev/account.getCounters
     */
    public VKRequest getCounters(VKParameters params) {
        return prepareRequest("getCounters", params);
    }

    /*
     * https://vk.com/dev/account.getInfo
     */
    public VKRequest getInfo() {
        return prepareRequest("getInfo", null);
    }

    /*
     * https://vk.com/dev/account.getInfo
     */
    public VKRequest getInfo(VKParameters params) {
        return prepareRequest("getInfo", params);
    }

    /*
     * https://vk.com/dev/account.getProfileInfo
     */
    public VKRequest getProfileInfo() {
        return prepareRequest("getProfileInfo", null);
    }

    /*
     * https://vk.com/dev/https://vk.com/dev/account.getPushSettings
     */
    public VKRequest getPushSettings() {
        return prepareRequest("getPushSettings", null);
    }

    /*
     * https://vk.com/dev/https://vk.com/dev/account.getPushSettings
     */
    public VKRequest getPushSettings(VKParameters params) {
        return prepareRequest("getPushSettings", params);
    }

    /*
     * https://vk.com/dev/account.lookupContacts
     */
    public VKRequest lookupContacts(VKParameters params) {
        return prepareRequest("lookupContacts", params);
    }

    /*
     * https://vk.com/dev/account.registerDevice
     */
    public VKRequest registerDevice(VKParameters params) {
        return prepareRequest("registerDevice", params);
    }

    /*
     * https://vk.com/dev/account.saveProfileInfo
     */
    public VKRequest saveProfileInfo(VKParameters params) {
        return prepareRequest("saveProfileInfo", params);
    }

    /*
     * https://vk.com/dev/account.setInfo
     */
    public VKRequest setInfo(VKParameters params) {
        return prepareRequest("setInfo", params);
    }

    /*
     * https://vk.com/dev/account.setNameInMenu
     */
    public VKRequest setNameInMenu(VKParameters params) {
        return prepareRequest("setNameInMenu", params);
    }

    /*
     * https://vk.com/dev/account.setOffline
     */
    public VKRequest setOffline() {
        return prepareRequest("setOffline", null);
    }

    /*
     * https://vk.com/dev/account.setOnline
     */
    public VKRequest setOnline() {
        return prepareRequest("setOnline", null);
    }

    /*
     * https://vk.com/dev/account.setPushSettings
     */
    public VKRequest setPushSettings(VKParameters params) {
        return prepareRequest("setPushSettings", params);
    }

    /*
     * https://vk.com/dev/account.setSilenceMode
     */
    public VKRequest setSilenceMode() {
        return setSilenceMode(null);
    }

    /*
     * https://vk.com/dev/account.setSilenceMode
     */
    public VKRequest setSilenceMode(VKParameters params) {
        return prepareRequest("setSilenceMode", params);
    }

    /*
     * https://vk.com/dev/account.unbanUser
     */
    public VKRequest unbanUser(VKParameters params) {
        return prepareRequest("unbanUser", params);
    }

    /*
     * https://vk.com/dev/account.unregisterDevice
     */
    public VKRequest unregisterDevice(VKParameters params) {
        return prepareRequest("unregisterDevice", params);
    }

    @Override
    protected String getMethodsGroup() {
        return "account";
    }
}