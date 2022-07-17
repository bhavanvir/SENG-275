# Bhavanvir Rai
#### SENG 275 Lab 8

**Console output for practice GET request:** `https://pokeapi.co/api/v2/pokemon/snorlax`
```
GET /api/v2/pokemon/snorlax HTTP/1.1
User-Agent: PostmanRuntime/7.29.0
Accept: */*
Postman-Token: 79243863-948a-4377-b30f-67520111941a
Host: pokeapi.co
Accept-Encoding: gzip, deflate, br
Connection: keep-alive
 
HTTP/1.1 200 OK
Date: Sun, 17 Jul 2022 02:55:30 GMT
Content-Type: application/json; charset=utf-8
Transfer-Encoding: chunked
Connection: keep-alive
alt-svc: h3=":443"; ma=86400, h3-29=":443"; ma=86400
access-control-allow-origin: *
Cache-Control: public, max-age=86400, s-maxage=86400
etag: W/"4a052-cRsK7VsOY9lEz85BPZ9ZAR5hK0s"
function-execution-id: 451envb90ctx
strict-transport-security: max-age=31556926
x-cloud-trace-context: 208ec741607cb03bdfca0de5ef8c9cf4
x-country-code: CA
x-powered-by: Express
x-served-by: cache-yyc1430034-YYC
x-cache: MISS
x-cache-hits: 0
x-timer: S1658023403.658889,VS0,VE379
vary: Accept-Encoding,cookie,need-authorization, x-fh-requested-host, accept-encoding
CF-Cache-Status: HIT
Age: 3127
Expect-CT: max-age=604800, report-uri="https://report-uri.cloudflare.com/cdn-cgi/beacon/expect-ct"
Report-To: {"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v3?s=KgtLLH5Ms1XbTO%2BZHtz%2BzphtKBIyup1i33CLqCM7AgxwjhrCVN9DnSC613%2FoyfQ1gVai5MvK%2B6%2Fn5Nkmt6ETe7vt2PiLVPmuiIMw4dEHjyMesxRX3xnfPqH3mCqj"}],"group":"cf-nel","max_age":604800}
NEL: {"success_fraction":0,"report_to":"cf-nel","max_age":604800}
Server: cloudflare
CF-RAY: 72bfb2f6186d8431-YVR
Content-Encoding: br
```
<br>

**5 API Tests:**

TC01: using GET request: `https://pokeapi.co/api/v2/ability/1`
```
pm.test("Body matches string", function () {
    pm.expect(pm.response.text()).to.include("Hat im Kampf keinen Effekt.");
});
```
TC02: using GET request: `https://pokeapi.co/api/v2/ability/1`
```
const jsonData = pm.response.json();
pm.test("Test data type of the response", () => {
    pm.expect(jsonData).to.be.an("object");
    pm.expect(jsonData.id).to.be.a("number");
    pm.expect(jsonData.name).to.be.a("string");
    pm.expect(jsonData.is_main_series).to.be.a("boolean");
    pm.expect(jsonData.generation).to.be.an("object");
    pm.expect(jsonData.names).to.be.an("array");
    pm.expect(jsonData.effect_entries).to.be.an("array");
    pm.expect(jsonData.effect_changes).to.be.an("array");
    pm.expect(jsonData.flavor_text_entries).to.be.an("array");
    pm.expect(jsonData.pokemon).to.be.an("array");
})
```

TC03: using GET request: `https://pokeapi.co/api/v2/characteristic/1`
```
const jsonData = pm.response.json();
pm.test("Test array properties", () => {
    const descriptionMessage = jsonData.descriptions.find
        (m => m.description === "たべるのが　だいすき");
    pm.expect(descriptionMessage).to.be.an("object");
    pm.expect(jsonData.possible_values).to.include(20);
});
```

TC04: using GET request: `https://pokeapi.co/api/v2/pokemon/snorlax/encounters`
```
pm.test("Content-Type header is application/json", () => {
  pm.expect(pm.response.headers.get('Content-Type')).to.eql('application/json; charset=utf-8');
});
```

TC05: using GET request: `https://pokeapi.co/api/v2/pokemon/snorlax/encounters`
```
pm.test("Response time is less than 200ms", () => {
  pm.expect(pm.response.responseTime).to.be.below(200);
});
```
