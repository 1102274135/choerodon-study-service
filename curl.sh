#!/usr/bin/env bash
TOKEN=$(curl 'http://api.dev.devopseasy.com/oauth/oauth/token?client_id=client&client_secret=secret&grant_type=password&password=YWRtaW4%3D&username=admin' -X POST -H 'Accept: application/json, text/plain, */*'|awk -F '"' '{print $4}')
echo $TOKEN
echo "-------插入organization和project-----------"
curl 'http://localhost:8080/25700/v1/organizations/aim/1' -X POST -H 'Accept: application/json, text/plain, */*' -H "Authorization: Bearer $TOKEN"
echo "-------插入user-----------------"
curl 'http://localhost:8080/25700/v1/users/aim/1/1' -X POST -H 'Accept: application/json, text/plain, */*' -H "Authorization: Bearer $TOKEN"
echo "-------查询user-----------------"
curl 'http://localhost:8080/25700/v1/users/1/users/1' -X GET -H 'Accept: application/json, text/plain, */*' -H "Authorization: Bearer $TOKEN"
echo "-------查询Organzition-----------------"
curl 'http://localhost:8080/25700/v1/organizations/1' -X GET -H 'Accept: application/json, text/plain, */*' -H "Authorization: Bearer $TOKEN"
echo "-------查询Project-----------------"
curl 'http://localhost:8080/25700/v1/orgaizations/1/projects?page=1' -X GET -H 'Accept: application/json, text/plain, */*' -H "Authorization: Bearer $TOKEN"