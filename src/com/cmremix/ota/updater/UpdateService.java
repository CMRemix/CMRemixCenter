/*=========================================================================
 *
 *  PROJECT:  SlimRoms
 *            Team Slimroms (http://www.slimroms.net)
 *
 *  COPYRIGHT Copyright (C) 2013 Slimroms http://www.slimroms.net
 *            All rights reserved
 *
 *  LICENSE   http://www.gnu.org/licenses/gpl-2.0.html GNU/GPL
 *
 *  AUTHORS:     fronti90, mnazim, tchaari, kufikugel
 *  DESCRIPTION: SlimOTA keeps our rom up to date
 *
 *=========================================================================
 */

package com.cmremix.ota.updater;

import android.content.Intent;
import android.util.Log;

import com.cmremix.ota.settings.Settings;

import com.commonsware.cwac.wakeful.WakefulIntentService;

public class UpdateService extends WakefulIntentService {
    private static final String TAG = "UpdateService";

    private static boolean mNoLog = true;

    public UpdateService(String name) {
        super(name);
    }

    public UpdateService() {
        super("CMRemixOtaService");
    }

    /* (non-Javadoc)
     * @see com.commonsware.cwac.wakeful.WakefulIntentService#doWakefulWork(android.content.Intent)
     */
    @Override
    protected void doWakefulWork(Intent intent) {
       if (mNoLog == false) Log.d(TAG, "CMRemix OTA Update service called!");
       if (Settings.isUpdateEnabled(getBaseContext())) {
           UpdateChecker otaChecker = new UpdateChecker();
           otaChecker.execute(getBaseContext());
       }
    }

}
