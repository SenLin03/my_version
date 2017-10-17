#Homework Management System
This system is aiming to provide a basic forum for
λ	Students to discuss and upload homework
λ	Teachers to manage the student users

It is based on Idea + Maven + SSM (Spring+Spring MVC+ MyBatis) + shiro + mysql + tomcat. The front-end UI uses AmazeUI
λ	Environment set up: http://blog.csdn.net/gallenzhang/article/details/51932152
λ	AmazeUI Introduction (http://amazeui.org/getting-started
ν	Download: https://github.com/amazeui

Request flow
View    ->   controller   ->   service   ->   dao    ->   entity
	Users interact with the view that generates the request. Requests are sent to the controller. Then, services and Dao are called, actions are performed, result in entity.



View（JSP pages），in the view directory
　   ▼
Controller，in the controller directory
　　▼
Busness logic Layer，in the service directory
　　▼
Data persistence layer，in the dao directory
　　▼
Entity Layer（JavaBean），in the entity directory
 
When modifying the layers, it is recommended to modify from the bottom layer to the top layer
Entity Layer
1.	First, Modify the entity
a)	User (id, username, password, email, etc)
b)	Homework (title, content, etc)
c)	Weather(temp, etc)
…		
d)	Then, modify the Page class
MyBatis Interceptor prepares the sql requests and separates it in pages
public class Page<T>
　　　　			List<T> pageNo, pageSize, total
Data persistence layer，
2.	Modify the IUserDao
a)	get user information based on user name, email
3.	Modify the IRoleDao, IHomeworkDao
a)	Get the permission resource ID
...
Business logic Layer, service，mainly for Authentication
4.	Modify the UserService
a)	Change password …
5.	Modify the HomeworkService
a)	Query paging data …
　　　　Create, Read, Update, Delete, CRUD the data entity


View Layer
Path: (/HomeworkManageSystem-master-2/src/main/webapp)
λ	The ‘view’ directory contains the view layer pages in the ../ WEB-INF/view.
ν	The ‘error’ directory contains the error pages. The pages that have not been complete designed could also be directed to these pages.
λ	The ‘static’ directory contains the css files and the third party libraries

Database Layer
Path: ./HomeworkManageSystem-master-2/db
	Database specification is in this directory which includes tables and attributes.

Controller
Model
