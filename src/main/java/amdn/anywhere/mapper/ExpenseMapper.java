package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.Expense;
import amdn.anywhere.domain.Sales;

@Mapper
public interface ExpenseMapper {

	
	// 1. 항목리스트
	public List<Expense> getExpenseList();
}
