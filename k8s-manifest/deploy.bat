kubectl create -f ingame-deployment.yaml -f lobby-deployment.yaml -f rank-storage-sts.yaml
kubectl create -f ingame-service.yaml -f lobby-service.yaml -f rank-storage-service.yaml
kubectl create -f https-ingress.yaml https-secret.yaml