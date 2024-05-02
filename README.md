


**Description:**

Here is a brief example of an online store. HTPP implements interaction with the store.
All shop entities (categories, products, and purchases) are stored in the `H2` database.

The StoreApp class should be run to initiate the store application.

The following happens when the StoreApp starts.
- 3 categories are inserted into `category` and randomly products are inserted into `products` - this behavior left from the previous task.
- HTTP Server starts on 8000 port.

There are 2 ways for interacting with store: `REST API` and `Console Comand`. 
Console commands emulate the client's HTTP client side.

CONSOLE | ENDPOINT | TYPE | DESCRIPTION | BODY |
--- |--- | --- | --- | --- | 
category | /get-category | GET | returns select from `category` |
| | /get-products | GET | returns select from `product` |
sort | /get-sort-products | GET | returns select sorted products from `product` |
top | /get-top-products | GET | returns select TOP 5 products from `product` |
| | /post-purchase | POST | inserts purchase from body request into `purchase` | body request's example see below
create_random_purchase | /create-random-purchase | GET | inserts randomly product into `purchase` |
print_purchases | /get-purchases | GET | selects products from `purchase`  |
clear_purchases | /clear-purchases | GET | deletes products from `puchase` |

body of `/post-purchase`

```
{
  "name": "Test",
  "rate": 11,
  "price": 22,
  "category_name": "Bike"
}
```
