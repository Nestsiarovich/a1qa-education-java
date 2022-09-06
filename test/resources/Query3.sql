CREATE DEFINER=`root`@`localhost` PROCEDURE `Query3`()
BEGIN
SELECT project.name AS PROJECT, test.name AS TEST, test.start_time AS DATE
FROM test, project
WHERE (test.start_time >= '2015-11-7 00:00:00')
ORDER BY project.name ASC, test.name ASC;
END