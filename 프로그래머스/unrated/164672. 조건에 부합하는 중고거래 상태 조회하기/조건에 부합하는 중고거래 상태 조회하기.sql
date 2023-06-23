-- 코드를 입력하세요
SELECT board_id, writer_id, title, price, 
CASE WHEN STATUS = 'SALE' THEN '판매중'
    WHEN STATUS = 'RESERVED' THEN '예약중'
    ELSE '거래완료'
    END AS STATUS
from used_goods_board
where created_date = '2022-10-5'
order by board_id desc