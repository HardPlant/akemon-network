# How to Write Yaml

### Basic

##### Pod

Container의 묶음
여러 Container를 묶는 개념

##### Deployment

Pod의 바람직한 상태

Pod가 4개라면 Deployment도 4개

상태가 있는 Pod라면 Deployment 대신 StatefulSet으로 관리해야 함

##### StatefulSet

Deployment에서 Kind를 바꿔주고 Volume을 추가해주는 것으로 사용 가능함

##### Service

Pod의 label들을 읽어 외부 포트를 할당함


### Pod의 용량 작성

[참고자료](https://kubernetes.io/docs/concepts/configuration/manage-compute-resources-container/)

```
spec.containers[].resources.limits.cpu
spec.containers[].resources.limits.memory
spec.containers[].resources.requests.cpu
spec.containers[].resources.requests.memory
```

##### CPU

* 하나의 AWS vCPU, GCP Core를 말함

* 0~1 사이의 값 (0.5 === 50%)

0.1 === 100m (100milli)

##### memory

K, M, G, T, P, E로 작성 가능 (ex) 1M = 10^6Byte)
i를 붙이면 2승 (ex) 1Mi = 2^20Byte = 1024KiB

### Volume의 용량 작성

### 단일 Pod

### 여러 Pod