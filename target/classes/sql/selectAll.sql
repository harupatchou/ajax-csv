select shop.name,shop.detail,
(
select cate.name
from categories cate
where cate.id = shop.category_id 
)
from shops shop