# Function to create a database application via a template
function createService() {
  oc new-app -f ./postgres-full.json \
    -p "APP_NAME=${APP}" \
    -p "MEMORY_LIMIT=${MEM_LIM}" \
    -p "DATABASE_SERVICE_NAME=${DB_SERVICE}" \
    -p "POSTGRESQL_USER=${USER}" \
    -p "POSTGRESQL_PASSWORD=${PWD}" \
    -p "POSTGRESQL_DATABASE=${DB_NAME}" \
    -p "INIT_SECRET=${INIT_SECRET}" \
    -p "VOLUME_CAPACITY=${VOL_LIM}" \
    -p "POSTGRESQL_VERSION=${VERSION}"
}

# Delete the database application resources
function deleteService() {
  oc delete all -l app=${APP}
  oc delete pvc/${DB_SERVICE}
  oc delete secret/${DB_SERVICE}
}
