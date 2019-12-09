
SELECT year, BANK_NAME, SUM(amount) AS total
FROM TB_BANK_FINANCE
GROUP BY BANK_NAME, year
Order by year , total DESC

SELECT b.year, b.BANK_NAME, b.total
FROM (
SELECT year, BANK_NAME, SUM(amount) as total, ROW_NUMBER() OVER (PARTITION BY YEAR ORDER BY SUM(amount) DESC) AS RankNo
FROM TB_BANK_FINANCE
GROUP BY BANK_NAME, year
ORDER BY year ) b
WHERE b.RankNo = 1 AND b.year = 2006


SELECT m.year, SUM(m.amount),
    SUM(CASE WHEN m.BANK_NAME = '주택도시기금' THEN m.amount ELSE 0 END),
    SUM(CASE WHEN m.BANK_NAME = '국민은행' THEN m.amount ELSE 0 END),
    SUM(CASE WHEN m.BANK_NAME = '우리은행' THEN m.amount ELSE 0 END),
    SUM(CASE WHEN m.BANK_NAME = '신한은행' THEN m.amount ELSE 0 END),
    SUM(CASE WHEN m.BANK_NAME = '한국시티은행' THEN m.amount ELSE 0 END),
    SUM(CASE WHEN m.BANK_NAME = '하나은행' THEN m.amount ELSE 0 END),
    SUM(CASE WHEN m.BANK_NAME = '농협은행/수협은행' THEN m.amount ELSE 0 END),
    SUM(CASE WHEN m.BANK_NAME = '외환은행' THEN m.amount ELSE 0 END),
    SUM(CASE WHEN m.BANK_NAME = '기타은행' THEN m.amount ELSE 0 END))
FROM BankHousingFinance m 
group by m.year
                
                
SELECT BANK_NAME, year, AVG(amount) AS average
FROM SupportAmount sa  
GROUP BY BANK_NAME, year  
HAVING BANK_NAME = '외환은행' AND year >= 2005 AND year <= 2016 And COUNT(year) = 12 
Order by average

select MAX(average), MIN(average), b.BANK_NAME
from(
SELECT BANK_NAME, year, AVG(amount) AS average
FROM TB_BANK_FINANCE  sa
GROUP BY BANK_NAME, year
HAVING BANK_NAME = '외환은행' And COUNT(year) = 12
Order by average) b