# Java library which provides developers notification via messengers 

[![Build Status](https://travis-ci.org/fedorchuck/dnjson.svg?branch=master)](https://travis-ci.org/fedorchuck/dnjson)
[![Apache License Version 2.0](https://img.shields.io/badge/license-Apache%20License%202.0-brightgreen.svg)](https://github.com/fedorchuck/dnjson/blob/master/LICENSE.md)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.fedorchuck/dnjson/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.fedorchuck/dnjson)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/4a58d74a6b6443c28a62656de1587f49)](https://www.codacy.com/app/vl.fedorchuck/dnjson?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=fedorchuck/dnjson&amp;utm_campaign=Badge_Grade)

## Introduction
Sometimes every developer needs to know about the event that happened as soon as possible. For example, about incorrect 
work of the server or about changing the third-party rest-api, about anything, depending on the specifics of the project.
 
There are many ways to inform developers about such events - all sorts of services, loggers. But most of them send 
notifications to the mail or a issue tracking system of a different type, which is not always convenient and not always possible to track quickly.

This library sending notifications to messengers. Just create and connect a bot in the messenger that your team using 
and that is supported by this library. For now it is Slack and Telegram. Add the library to the project, add it configuration (access keys to the bot that you created), add lines, where it is needed, to send message and you receive messages when something happened.

Also, this library have monitoring module. It can monitor current usage of RAM and disk memory, set limits of their 
usage and in case of overspending - informs to the selected messengers.

This library compatible with Java 6+


## Contents

- [Getting started](#getting-started)
  - [Download](#download)
  - [Setup](#setup)
- [Changelog](#changelog)
- [License](#license)

## Getting started
### Download
Gradle:
```groovy
compile 'com.github.fedorchuck:dnjson:0.1.0'
```
Maven:
```xml
<dependency>
  <groupId>com.github.fedorchuck</groupId>
  <artifactId>dnjson</artifactId>
  <version>0.1.0</version>
</dependency>
```
JAR-files:  
https://oss.sonatype.org/content/repositories/releases/com/github/fedorchuck/dnjson/

### Setup
The library is configured by environment variables or system properties. Supported variable is `DN`. It is single 
environment variable witch required if you use this library. Accepted value is JSON:
```json
{
	"messenger": [{
		"name": "SLACK",
		"token": "SLACK_TOKEN",
		"channel": "SLACK_CHANNEL"
	}, {
		"name": "TELEGRAM",
		"token": "TELEGRAM_TOKEN",
		"channel": "TELEGRAM_CHANNEL"
	}],
	"show_whole_log_details": true,
	"protection_from_spam": true,
	"project_name": "Where this library will be invoked",
	"connect_timeout": 5000,
	"user_agent": "Mozilla/5.0",
	"monitoring": {
		"period": 5,
		"unit": "seconds",
		"max_ram": 90,
		"max_disk": 90,
		"disk_consumption_rate": 2
	}
}
```
## Changelog
See [changelog file](https://github.com/fedorchuck/dnjson/blob/master/CHANGELOG.md)

## License
This software is licensed under [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)
