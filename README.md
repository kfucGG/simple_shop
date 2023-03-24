# simple_shop

buyer-service endpoints:

<br>POST /buyer/buy?productId={} - купить товар<?br>
POST /buyer/grade - поставить оценку товару (нельзя если не куплен товар)<?br>
POST /buyer/review - оставить отзыв (нельзя если не куплен товар)
GET /buyer/orders - история покупок
DELETE /buyer/orders/refund?orderId={} - вернуть , если не прошел день с момента покупки

GET /buyer/notice - уведомления пользователя

POST /buyer/organization/new - регистрация новой организации
POST /buyer/organization/newproduct - отправить запрос на рег продукта(только если орг прошла модерацию)

admin-service endpoints:
POST /admin/products/add - добавить новый товар
POST /admin/{productId}/update - обновить товар

POST /admin/discounts/add/{productId} - добавить скидку к товару
POST /admin/discounts/add/organization?organizationId={} - добавить скидку ко всем товарам организации
POST /admin/discounts/add/name?productName={} -  добавить скидку ко всем продуктам с опр именем

PATCH /admin/discounts/update/{productId} - обновить скидку товара
PATCH /admin/discounts/update/name?productName={} - обновить скидку у всех тов. с определ. именем
PATCH /admin/discount/update/organization?organizationId - обновить скидку всеъ товаров организации

GET /admin/orders/{userid} - история покупок пользователя

GET /admin/users - все пользователи
GET /admin/users/{userId} - определенный пользователь
DELETE /admin/users/{userId}/delete - удалить пользователя
POST /admin/users/{userId}/addbalance?sum={} - пополнить баланс пользователя

POST /admin/notice - отправить уведомление пользователю

POST /admin/organization/allow?organizationId={} - разреш организации отправлять заявки на добавление товаров
POST /admin/organization?productRequestId={} - одобрить запрос на добавление продукта
