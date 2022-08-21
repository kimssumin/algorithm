select first_name, last_name, room_no
from customers

left outer join reservations as re
on customers.customer_id = re.customer_id
order by first_name, last_name, room_no


#아래줄 작성 x
where date_in in (2022-01-01, 2022-01-30)