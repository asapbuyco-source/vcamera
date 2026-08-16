# VCamera

This is a powerful app that allows you to replace the camera with the video you specify.  </b>  
 It can be used as a live broadcast assistant, such as using local movies as live broadcast content. </b>    
 It can also be used to prevent APP sneak shots. </b>    

# Scenes to be used:
1. Protect the privacy of the camera and prevent some apps from maliciously taking pictures.  
2. Live Assistant. Similar to OBS, but may be better than OBS, can be used for Twitch, Youtube, Facebook, etc.  
3. Entertainment among friends. How fun it would be to record a hilarious video to prank your friends. 

**Notice:**  
**Please strictly abide by the laws and regulations. It is strictly forbidden to use this APP for any illegal activities, otherwise you will bear the consequences.**  


# QA:
**If you are the owner of an APP,How to detect if you don’t want your APP to run in VCamera?**  
VCamera is based on a virtual machine, so you can detect whether it is currently running in a virtual machine environment.  
[Check Env Demo Code](https://github.com/andvipgroup/VCamera/tree/main/check_env_demo/code)  
[Check Env Demo Apk](https://github.com/andvipgroup/VCamera/blob/main/check_env_demo/check_env_demo.apk)  <br><br>
![Check Env Demo Apk Screenshot](https://github.com/andvipgroup/VCamera/blob/main/check_env_demo/check_result.png?raw=true)  
Here "isPathReallyExist  < 0" means it running in a virtual machine.  
If "isPathReallyExist = 0" means it running in a real device.  



# Demo Video
[![Watch the video](https://img.youtube.com/vi/lT-MP9c7SbY/maxresdefault.jpg)](https://www.youtube.com/embed/lT-MP9c7SbY)


# Key Features
**1. Support replacing the camera with a photo.**  
**2. Support replacing the camera with video.**  
**3. Support to replace the camera with network video.**  
**4. Support resizing video, rotating, moving, zooming, flipping, etc.**  



# Contact Me
andvipgroup@gmail.com

# APK Download
**Latest version : 3.5.4**  
<p align="left">
  <a href='https://play.google.com/store/apps/details?id=virtual.camera.app'>
    <img alt='Get it on Google Play' height='90' src='https://github.com/andvipgroup/VCamera/blob/main/gp.png'/>
  </a>
</p>

# Build & Recovery Notes (2026)

## Current build state

- `opensdk` submodule restored (`com.hack.opensdk`, the VM engine, AGPL-3.0,
  commit `eaab164` "Release v1.2.9"). It ships the engine jar
  (`opensdk/src/main/assets/moon.jar`), native libs (`libmultiapp.so`, `libl.so`,
  `libpl.so` for armeabi-v7a/arm64-v8a) and a GMS installer APK
  (`com.waxmoon.ma.gp.apk`). All `HackApi` methods used by the app match this
  engine version. `hackJarName` in the root build file was updated to
  `moon.jar` accordingly.
- The proprietary camera library `virtual.camera.camera:camera:1.0.0` is
  **extinct**: its GitHub maven repo (`andvipgroup/CameraLib`) is deleted
  (404), it is not on Maven Central / JitPack / Gitee, has no surviving fork,
  and is not in the Wayback Machine or any APK mirror (the Play listing
  `virtual.camera.app` was replaced by a successor product that no longer
  ships this library).
- Because of that, a local stub module `cameralib` provides the
  `virtual.camera.camera.MultiPreferences` API (settings persistence only).

**Consequence:** the project now compiles and works as a VM app launcher, but
**camera replacement is NOT included** - the original hook/playback engine was
only available in the lost AAR and cannot be recovered.

**Note:** the engine design is dual-package (`masterPkg` +
`assistPkg = com.asapbuyco.source.assist`, see root build file). The assist
variant is built with `isMasterPkg = false` and may need to be installed
alongside the master APK for the engine to fully boot. Test on a real device.

## Working camera-replacement tool (vendor's current release)

The vendor's current APK (same package `virtual.camera.app`, includes the
camera-hook engine) is provided in `dist/` (split APK set):

```
dist/virtual.camera.app.apk      # base
dist/config.arm64_v8a.apk        # native libs (required)
dist/config.xxhdpi.apk           # density resources (recommended)
dist/config.en.apk               # locale (optional)
dist/config.zh.apk               # locale (optional)
```

Install all chosen splits in one session with an installer that supports
split APKs (e.g. SAI - Split APKs Installer), selecting base + arm64 + xxhdpi
+ one locale. Alternatively use the vendor's Play Store listing
("Virtual Camera : Live Assist").

## Known fixes applied

- `SettingFragment.copyLocalVideo()`: the copy loop wrote full 1 KB buffers
  instead of the read byte count (and double-wrote at EOF), corrupting the
  tail of local videos. Fixed to `write(buffer, 0, len)`.
- Removed the dead `andvipgroup/CameraLib` maven repo and its dependency line.
