cmd
SET generator=spring
SET target_dir=api-sdk
SET api_package=io.hardplant.api
openapi-gen generate -g %generator% -o %target_dir% -i openapi.yml --api-package %api_package%
exit