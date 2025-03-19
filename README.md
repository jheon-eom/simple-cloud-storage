## 프로젝트 개요

i-Cloud 및 Google Drive와 유사한 기능을 제공하는 개인 클라우드 저장소를 구축하는 프로젝트입니다. <br>
운영체제의 파일 시스템을 이해하고, 멀티스레드를 활용한 병렬 업로드, 헥사고날 아키텍처 적용, 서블릿 필터 기반 인증/인가 등을 직접 구현합니다.

## 기술 스택

  • Java 21 <br>
  • SpringBoot 3.4.1 <br>
  • Gradle <br>
  • MySQL, H2 <br>
  • Junit, Mockito <br>
  • Docker

## 주요 기능

1. 파일 업로드 및 다운로드 <br>
	•	멀티스레드를 활용한 대용량 파일 업로드 최적화 <br>
	•	업로드 시 파일을 여러 개의 청크로 분할하여 병렬 업로드 수행 (사용 중인 로컬 기기: 8코어) <br>
	•	파일 병합 후 저장하여 성능 향상 <br>
	•	파일 다운로드 지원 <br>
	•	업로드된 파일을 다시 다운로드 가능 <br>
	•	특정 범위 다운로드 지원 (Range Request) <br>

2. 운영체제의 파일 시스템 활용 <br>
	•	파일 저장 및 관리 <br>
	•	로컬 운영체제의 파일 시스템을 직접 활용하여 스토리지 구축 <br>
	•	사용자 프로세스에서 시스템 콜을 이용해 파일을 효율적으로 관리 <br>

3. 인증/인가 구현 (Spring Security 미사용) <br>
	•	서블릿 필터와 ThreadLocal을 활용한 사용자 인증/세션 관리 <br>
	•	Spring Security 등의 프레임워크를 사용하지 않고, 서블릿 필터(Servlet Filter)를 직접 구현하여 JWT 기반 인증 처리 <br>
	•	ThreadLocal을 사용하여 요청 단위의 인증 객체 관리 <br>

## 프로젝트 아키텍처

헥사고날(육각형) 아키텍처 적용 (Port-Adapter Pattern) <br>
├── adapter
│   ├── in
│   │   ├── web (REST API 컨트롤러)
│   │   └── dto (데이터 전송 객체)
│   └── out
│       ├── persistance (database)
│       └── external (외부 api)
├── application
│   ├── service (계층간 통신)
│   ├── dto (데이터 전송 객체)
│   └── port (데이터 전송 객체)
│       ├── in (데이터 전송 객체)
│       └── out (데이터 전송 객체)
└── domain
    └── model (핵심 도메인 모델)

## TODO (추후 개선 사항)

  • 실시간 업로드 짆애률 표시 (WebSocket 사용) <br>
  • 로컬 파일 시스템 외에 AWS S3 및 외부 저장소 지원 <br>
  • 다중 사용자 간 파일 공유 기능 지원
