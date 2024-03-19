
Simple Inventory Management Protocol (SIMP)
Whenever you develop a server application, you need to specify some
application-level protocol that clients can use to interact with the server.
For the purpose of this example, we will create a "Simple Inventory Management Protocol".
The table below shows the protocol format. Of course, this is just a toy
protocol to show you how to implement a server.

| Client Request | Server Response            | Description                                    |
|----------------|----------------------------|------------------------------------------------|
| INFO n         | n and the product info     | Get the count, cost, and discount of product n |
| ADD n a        | n and the new product info | Add amount a into product n                    |
| REMOVE n a     | n and the new product info | Remove amount a from product n                 |
| DISCOUNT n a   | n and the new product info | Set discount amount a for product n            |
| NODISCOUNT n   | n and the new product info | Set discount amount 0 for product n            |
| QUIT           | Quit the connection        |                                                |

Author: Matthew Miss