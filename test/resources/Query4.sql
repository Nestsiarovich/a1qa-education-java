CREATE DEFINER=`root`@`localhost` PROCEDURE `Query4`()
BEGIN
SELECT COUNT(test.name) AS BROWSERS 
FROM test
WHERE test.browser = 'firefox'
UNION
SELECT COUNT(test.name) AS BROWSERS 
FROM test
WHERE test.browser = 'chrome';
END