# CrawSecurity
Android Application for Craw Security
Android studio has been used to develop the application's front as well as backend .User authentication os done using Firebase authentication which allows us to handle custom as well as google account user's authentication.  The database used is Firebase realtime database that allows to read and write into our database for authenticated users to store tokens.

### Possible Crash Reason
Permission for application needs to be set in the application settings in Application manager:
Permission for Phone and For Locations need to be enabled for application to run properly.

## Read status
You can detect how much battery is left, display IMEI, SIM card ID and much more.
### Status
![Alt Text](https://github.com/adriel1997/CrawSecurity/blob/master/Screenshot_2018-04-16-21-29-35.png)

## Multiple phones on the same account
Multiple phones can log into the same account using firebase authentication.
### Sign UP
![Alt Text](https://github.com/adriel1997/CrawSecurity/blob/master/Screenshot_2018-04-16-21-29-43.png)
### Login
![Alt Text](https://github.com/adriel1997/CrawSecurity/blob/master/Screenshot_2018-04-16-21-29-39.png)

## Send Notification On Lost Devices
First time login on Device will genrate a token. Using this token a notification can be sent on that device if case it is stolen after user logins into account on another device.
### Notification
![Alt Text](https://github.com/adriel1997/CrawSecurity/blob/master/Screenshot_2018-04-17-18-45-29.png)

### Steps
#### 1)Database
##### After User has clicked Help button a request will go to database admin
![Alt Text](https://github.com/adriel1997/CrawSecurity/blob/master/database.PNG)
#### 2)Notification
##### Admin will copy the token for the help request and go to cloud messaging
![Alt Text](https://github.com/adriel1997/CrawSecurity/blob/master/notification.PNG)
#### 3)Compose Message
##### Admin will compose message for user and select single user and paste the token in FCM token
![Alt Text](https://github.com/adriel1997/CrawSecurity/blob/master/composemsg.PNG)
#### 4)Send Message
##### Admin will send the message after enabling sound in advance settings.
![Alt Text](https://github.com/adriel1997/CrawSecurity/blob/master/sendmsg.PNG)
