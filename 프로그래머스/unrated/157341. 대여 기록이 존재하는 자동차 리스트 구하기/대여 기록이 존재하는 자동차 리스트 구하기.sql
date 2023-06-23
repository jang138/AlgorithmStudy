-- 코드를 입력하세요
SELECT distinct car.car_id
from CAR_RENTAL_COMPANY_CAR car
left join CAR_RENTAL_COMPANY_RENTAL_HISTORY his
on car.car_id = his.car_id
where car.car_type = '세단' and month(his.start_date) = 10
order by car.car_id desc