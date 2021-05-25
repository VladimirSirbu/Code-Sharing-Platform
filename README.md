# Code-Sharing-Platform
A tool to share piece of code

## Description
Sometimes, it's useful to have a tool that can help you share a piece of code with other programmers. 
If there is a team of programmers who work in the same company and want to exchange pieces of code, they can solve this
problem by using their own implementations of service. Such a web service is supposed to be accessible only locally, not via the Internet.<br>
**Code-Sharing-Platform** is something like this. As a web service it offer you to follow and poste pieces of code.

## How to use
This project implements two type of interfaces: **API** and **Web** interface. <br>
The **API** interface could be accessed through endpoints that start with `/api` while web interface endpoints start with `/code`. <br>
After running this project, for accessing via web interface , open your browser and type as URL `localhost:8080` and follow next endpoints below: <br>
- `/code/new` : add new piece of code
- `/code/codeId` : access posted code through it's id , `codeId` must be an integer number 
- `/code/latest` : view last 10 posted piece of code from newest to oldest by posted time

<img src="/images/new-code.JPG">

<img src="/images/get-code-by-id.JPG">

<img src="/images/latest-code.JPG">

<hr>

For accessing via API interface, open for example Postman and also type as URL `localhost:8080` and follow next endpoints below: <br>
- `/api/code/new` : and new piece of code
- `/api/code/codeId` : access posted code through it's id , `codeId` must be an integer number 
- `/api/code/latest` : view last 10 posted piece of code from newest to oldest by posted time

<img src="/images/api-code-new.JPG">

<img src="/images/api-get-code-by-id.JPG">

<img src="/images/api-latest-code.JPG">

<hr>
