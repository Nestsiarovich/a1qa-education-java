CREATE DEFINER=`root`@`localhost` PROCEDURE `Query2`()
BEGIN
SELECT project.name AS PROJECT, COUNT(DISTINCT test.name) AS TESTS_COUNT
FROM project
INNER JOIN test
ON project.id = test.project_id
GROUP BY project.name;
END