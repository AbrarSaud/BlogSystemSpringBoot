##  API Endpoints

 ### CRUD(create, read, update, and delete data.).
- **User:**
  - `GET     /api/v1/blog/users/get `                - Get all users
  - `POST    /api/v1/blog/users/add   `              - Add a new user  
  - `PUT     /api/v1/blog/users/update/{user_id}  `       - Update a user by ID  
  - `DELETE  /api/v1/blog/users/delete/{user_id}   `      - Delete a user by ID
- **Post:**    
  - `GET     /api/v1/blog/posts/get `             -Get all posts  
  - `POST    /api/v1/blog/posts/add `             - Create new post  
  - `PUT     /api/v1/blog/posts/update/{post_id}`             - Update post by ID  
  - `DELETE  /api/v1/blog/posts/delete/{post_id}`             - Delete post by ID

- **Category:**
  - `GET     /api/v1/blog/category/get `             -Get all Category  
  - `POST    /api/v1/blog/category/add `             - Create new Category  
  - `PUT     /api/v1/blog/category/update/{category_id}`             - Update Category by ID  
  - `DELETE  /api/v1/blog/category/delete/{category_id}`             - Delete Category by ID
- **Comments:**
   
  - `GET     /api/v1/blog/comments/get `             -Get all comments  
  - `POST    /api/v1/blog/comments/add `             - Create new comments  
  - `PUT     /api/v1/blog/comments/update/{comments_id}`             - Update comments by ID  
  - `DELETE  /api/v1/blog/comments/delete/{comments_id}`             - Delete comments by ID

 ### 8 Endpoints use JPA and JPQL 

| #  | Endpoint                                                       | Description                                      |
|----|----------------------------------------------------------------|--------------------------------------------------|
| 1  | `GET /api/v1/blog/posts/get-by-post-id/{post_id}`             | Get all posts by Post ID                         |
| 2  | `GET /api/v1/blog/posts/get-by-title/{title}`                 | Get posts by Title                               |
| 3  | `GET /api/v1/blog/posts/get-by-date/{date}`                   | Get posts before  Date                           |
| 4  | `GET /api/v1/blog/posts/data-between/{start}/{end}`           | Get posts published between two dates            |
| 5  | `GET /api/v1/blog/comments/get-comment-by-post-id/{postId}`   | Get comments for a post by Post ID               |
| 6  | `GET /api/v1/blog/posts/get-by-keyword/{keyword}`             | Get posts that contain a specific keyword        |
| 7  | `GET /api/v1/blog/posts/get-by-category-name/{categoryName}`  | Get posts by Category name                       |
| 8  | `GET /api/v1/blog/users/get-users-before-date/{date}`         | Get users registered before date                 |


    
