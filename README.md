# SoftwareSystemsEngineering
Objected Oriented Programming and Design Patterns
SmartEat - Restaurant Automation Application
This application automates the traditional food ordering system, and the associated actions of all the actors viz. customer, owner waiter and chef.

Preconditions:
●	A restaurant has multiple customers, waiters, chefs but only one owner.
●	A restaurant also has multiple tables in it.
●	Each table in the restaurant has a touch sensitive device (e.g. a tablet) on it.
●	These devices have our application installed on it.
●	The application on each device is aware of 
○	the table they have been placed on.
○	the entire menu (with pricing) of the restaurant
●	 A waiter/waitress is associated to one or more table(s). (i.e each table has at least one waiter assigned to it).
●	When a customer walks in the restaurant, the waiter assists him/her to find a table to accommodate the party size.
●	The customer browses through the menu, and places an order via the application.
●	This order is associated with the customer, the table he/she is occupying, one chef and one waiter.
●	The chef receives the order, and cooks the dishes.
●	On completion of cooking, the waiter is notified, he takes the food to  the customer.
●	The app will smartly prompt the waiter to check on the customer frequently.
●	Once the customer is done, he can pay the bill via the app. He can leave feedback about the dishes, which can be forwarded to the chef (as compliments) or aggregated to modify the menu.
●	The waiter will be notified about cleaning up the table for the next customer. 


Actors and their use case list (Application feature list):

Customer:
●	Choose the menu and select a food item
●	Add a food item to cart
●	Remove a food item from the cart
●	Place order
●	Pay the bill (include paying tip to the waiter)
●	Rate the restaurant
●	Give feedback/compliments about a particular dish
●	Call/Notify the waiter for assistance while having the meal

Waiter:
●	Login/Logout from the application
●	Get order notifications from the customer
●	Place the order on behalf of customer
●	Push the order details to the chef
●	Get order cooking status notifications from the chef
●	Print the bill receipt for the customer
●	Clean the table for next customer

Chef:
●	Login/Logout from the application
●	Get order notifications (the applications gives notifications to the chef about the food dish to be made as customer orders it)
●	Notify the waiter once food is ready

Owner/Admin:
●	Login/Logout from the application
●	View list of waiters
●	View list of tables (Say occupied or unoccupied)
●	View list of orders and its associated payment information, say status
●	view list of chefs
●	View and edit (add, remove) the associated list of waiters and tables
●	Create, Retrieve (Look), Update, Delete the food menu items
