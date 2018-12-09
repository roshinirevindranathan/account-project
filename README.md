# account-project

This a simple service that accepts GET, POST and DELETE requests.
Please note that this project uses Lombok. If you an Intellij user, you need to tick 'Enable annotation processing' in the settings. You also need to install Lombok plugin.

## Endpoints:

### GET accounts:
/account-project/rest/account/json

### POST account:
/account-project/rest/account/json
with JSON body:
{"firstName": String,"secondName": String,"accountNumber": String}

### DELETE account:
/account-project/rest/account/json/{id}

