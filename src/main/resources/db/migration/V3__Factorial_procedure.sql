set term #;
create procedure factorial(max_value integer)
  returns (factorial bigint)
as
  declare variable counter integer;
begin
  factorial = 1;
  counter = 0;
  while (counter <= max_value) do
  begin
    if (counter > 0) then
      factorial = factorial * counter;
    counter = counter + 1;
  end
end#
set term ;#
