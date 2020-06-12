# DemoProjectTwo
Cheat sheet\

Create java project (e.g DemoProjectTwo) \
Add all the jars\
Create a java file under the src folder (eg. basics)\
Create base URI\
Add import static io.resassured.RestAssured.*; (in order to get given method)\
\
\
in order to assert .assertThat().statusCode(200).body("scope", equalTo("APP"));\
we need to import this manually - it will not give suggestion on right clicking "import static org.hamcrest.Matchers.*;" \


Testing OAuth API's using Postman and Rest Assured \

What is OAuth 2.0? \
OAuth 2 comes with multiple Grant types\
Authorization code and Client credentials are the most commonly used Grant types for OAuth\
Understand the flow of (Authorization code) Grant type with REal world exampels\
Back end implementation of Authorization code with different layers of security.\
Plan for generating Access token using API's in Postman for the complex flow of Authorization code Oauth 2.0\
API testing with generated Access token\
Automate complete OAuth 2.0 flow usign Rest Assured\
Shortcut to generate Access token for OAuth in postman\

