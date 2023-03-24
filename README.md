# simple_shop

Подразумевается, что все запросы проходят через gateway + вызываются только след сервисы:\
auth-service - на нем происходит auth/reg\
admin-service - весь функционал админа\
buyer-service - весь функционал обычного пользователя\
Другие сервисы:\
user-service - на нем хранятся все пользователи + операции над нами\
product-service - все товары + скидки, оценки, отзывы\
organization-service - все организации
notice-service - уведомления 

## buyer-service endpoints:

POST /buyer/buy?productId={} - купить товар\
POST /buyer/grade - поставить оценку товару (нельзя если не куплен товар)\
POST /buyer/review - оставить отзыв (нельзя если не куплен товар)\
GET /buyer/orders - история покупок\
DELETE /buyer/orders/refund?orderId={} - вернуть , если не прошел день с момента покупки\

GET /buyer/notice - уведомления пользователя\

POST /buyer/organization/new - регистрация новой организации\
POST /buyer/organization/newproduct - отправить запрос на рег продукта(только если орг прошла модерацию)\

## admin-service endpoints:\
POST /admin/products/add - добавить новый товар\
POST /admin/{productId}/update - обновить товар\

POST /admin/discounts/add/{productId} - добавить скидку к товару\
POST /admin/discounts/add/organization?organizationId={} - добавить скидку ко всем товарам организации\
POST /admin/discounts/add/name?productName={} -  добавить скидку ко всем продуктам с опр именем\

PATCH /admin/discounts/update/{productId} - обновить скидку товара\
PATCH /admin/discounts/update/name?productName={} - обновить скидку у всех тов. с определ. именем\
PATCH /admin/discount/update/organization?organizationId - обновить скидку всеъ товаров организации\

GET /admin/orders/{userid} - история покупок пользователя\

GET /admin/users - все пользователи\
GET /admin/users/{userId} - определенный пользователь\
DELETE /admin/users/{userId}/delete - удалить пользователя\
POST /admin/users/{userId}/addbalance?sum={} - пополнить баланс пользователя\

POST /admin/notice - отправить уведомление пользователю\

POST /admin/organization/allow?organizationId={} - разреш организации отправлять заявки на добавление товаров\
POST /admin/organization?productRequestId={} - одобрить запрос на добавление продукта\
