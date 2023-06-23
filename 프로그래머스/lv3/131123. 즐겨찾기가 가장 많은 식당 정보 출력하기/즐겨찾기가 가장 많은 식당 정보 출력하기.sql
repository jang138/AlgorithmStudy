-- 코드를 입력하세요, 한식 734, 중식 20, 일식 230, 양식 102, 분식 151
#SELECT food_type, rest_id, rest_name, max(favorites) as favorites
#from rest_info
#group by food_type
#order by food_type desc

SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO
WHERE (FOOD_TYPE, FAVORITES) 
IN 
(SELECT FOOD_TYPE, MAX(FAVORITES)
FROM REST_INFO
GROUP BY FOOD_TYPE )
ORDER BY FOOD_TYPE DESC