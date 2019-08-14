# How to Write Yaml

### Basic

##### Pod

Container의 묶음
여러 Container를 묶는 개념

##### Deployment

Pod의 바람직한 상태

Pod가 4개라면 Deployment도 4개

상태가 있는 Pod라면 Deployment 대신 StatefulSet으로 관리해야 함

##### Service

Pod의 label들을 읽어 외부 포트를 할당함

### 단일 Pod

### 여러 Pod