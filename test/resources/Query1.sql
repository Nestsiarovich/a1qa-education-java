CREATE DEFINER=`root`@`localhost` PROCEDURE `Query1`()
BEGIN
SELECT project.name AS PROJECT, test.name AS TEST, MIN(test.end_time-test.start_time) AS MIN_WORKING_TIME
FROM test 
INNER JOIN project
ON project.id = test.project_id
GROUP BY test.name
ORDER BY project.name ASC, test.name ASC;
END