# TCP

강의 번호: CS
복습: No
작성일시: 2023년 3월 15일 오후 10:49
학습 소스 출처 1: https://www.youtube.com/watch?v=K9L9YZhEjC0
학습 소스 출처 2: https://github.com/gyoogle/tech-interview-for-developer/blob/master/Computer%20Science/Network/TCP%20(%ED%9D%90%EB%A6%84%EC%A0%9C%EC%96%B4%ED%98%BC%EC%9E%A1%EC%A0%9C%EC%96%B4).md#tcp-%ED%9D%90%EB%A6%84%EC%A0%9C%EC%96%B4%ED%98%BC%EC%9E%A1%EC%A0%9C%EC%96%B4

### IP

패킷들이 가장 효율적인 방법으로 최종 목적지로 갈 수 있도록 해주는 프로토콜이다.

### TCP

IP의 상위 프로토콜

네트워크를 통해 정보를 전송할때 ,  이러한 데이터를 그대로 전송하는 것보단 작게나누어 (패킷 단위) 전송한다.

이러한 패킷단위를 재조립하고 , 손상되거나 손실된 패킷을 재요청하는 것이 TCP 프로토콜이다.

TCP는 IP 와 비교했을때 신뢰성있고 무결성을 보장하는 연결을 통해

데이터를 안전하게 전송해주는 전송 프로토콜이다.

### 패킷

네트워크에서 데이터를 보낼때 사용되는 작게 나눈 단위

네트워크에서 사용하는 데이터의 기본단위

### TCP/IP 통신

이러한 TCP 와 IP 프로토콜을 통합하여 사용하는 인터넷 전송 조약이다.

## TCP 통신 요약

- 네트워크 통신에서 신뢰적인 연결방식
- TCP 는 기본적으로 unreliable network에서, reliable network를 보장할 수 있도록 하는 프로토콜
- • TCP는 network congestion avoidance algorithm을 사용

## reliable network를 보장한다는 것은 4가지 문제점 존재

- 손실 : packet이 손실될 수 있는 문제
- 순서 바뀜 : packet의 순서가 바뀌는 문제
- Congestion : 네트워크가 혼잡한 문제
- Overload : receiver가 overload 되는 문제