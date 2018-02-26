# 过滤条件加排序，没什么特别的
select t.* from cinema t 
where t.description <> 'boring' and t.id % 2 = 1
order by t.rating desc;
