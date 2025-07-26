# Bookstore

A Bookstore project made in Java Spring

## Authors

- [@Kyrillosemad](https://www.github.com/Kyrillos8)

## Features

- Register a new user(can not create a user with the same username)
- Roles : make 3 main roles for the bookstore
  - Admin: can add/update/delete any book putting any author name     (admin will have a static account)
  - Author: can add books with his name as author + update/delete only his own books (under maintenance)
  - Viewer: can read only the books existing in the bookstore
- Login with a user made so can access the bookstore:

  - Retrieve a list of all books

  - Create a new book and assign the author to the user that created it

  - Retrieve a specific book by its ID

  - Update an existing book

  - Delete a book by its ID

- Logout (under maintenance)

Fixing 403 error for "h2-console" so can view the database through browser.

Error handling is done for all the endpoints and the user can see the error message in the response body.
