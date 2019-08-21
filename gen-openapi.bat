cmd
SET generator=spring
SET target_dir=api-sdk
SET api_package=io.hardplant
SET artifact_id=baseball
openapi-gen generate -g %generator% -o %target_dir% -i openapi.yml --group-id %api_package% --artifact-id %artifact_id%
exit