# Sample-PRJ-RoomAndPaging


**Room** 과 **Paging Library** 기본 사용법을 위한 샘플 프로젝트입니다.

![screenshot](https://github.com/sbean0215/Sample-PRJ-RoomAndPaging/blob/master/screenshot/Screenshot.jpg)
---
##### 함께 사용한 것

* Java, Android
* Architectural Pattern : MVVM 
* Libraris : Dagger2, Databinding, FCM, LiveData


---
##### FCM 메세지 전송시 구조

```
{
  "message":{
    "token":"bk3RNwTe3H0:CI2k_HHwgIpoDKCIZvvDMExUdFQ3P1...",
    "data":{
      "target_user_id" : "3",
      "msg_type" : "AD",
      "contents" : "Blah blah"
    }
  }
}
```
* msg_type : "AD", "NOTICE", "MESSAGE"