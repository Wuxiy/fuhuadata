package com.fuhuadata.domain.query;
/**
 * @author wangbo
 * 福华分页基础类
 */
public class PageBase {
		/**
		 * 默认每页的记录数量
		 */
		public static final int PAGESIZE_DEFAULT = 20;
		/**
		 * 每页大小
		 */
		private int pageSize;
		/**
		 * 当前页。第一页是1
		 */
		private int index;

		/**
		 * 总记录数
		 */
		private int totalItem;
		/**
		 * 总页数
		 */
		private int totalPage;

		/**
		 * 分页后的记录开始的地方 第一条记录是1
		 */
		@SuppressWarnings("unused")
		private int startRow;
		/**
		 * 分页后的记录结束的地方
		 */
		@SuppressWarnings("unused")
		private int endRow;

		/** 表id **/
		private Integer tableId;

		/** 排序字段 **/
		private String orderField;

		/** 升序 还是 降序,true为升序，false为降序 */
		private Boolean isAsc;

		/**
		 * 表示是不是第一页
		 * @return true 是; false 不是
		 */
		public boolean isFirstPage() {
			return index <= 1;
		}
		
		/**
		 * 判断是否为中间页
		 * @return true 是; false 不是
		 */
		public boolean isMiddlePage() {
			return !(isFirstPage() || isLastPage());
		}

		/**
		 * 判断是否为最后一页
		 * @return true 是; false 不是
		 */
		public boolean isLastPage() {
			return index >= totalPage;
		}

		/**
		 * 判断下一页是否可用
		 * @return true 是; false 不是
		 */
		public boolean isNextPageAvailable() {
			return !isLastPage();
		}

		/**
		 * 判断上一页是否可用
		 * @return true 是; false 不是
		 */
		public boolean isPreviousPageAvailable() {
			return !isFirstPage();
		}

		/**
		 * 下一页号
		 * @return 取得下一页号
		 */
		public int getNextPage() {
			if (isLastPage()) {
				return totalItem;
			} else {
				return index + 1;
			}
		}
		/**
		 * 上一页号
		 * @return 取得上一页号
		 */
		public int getPreviousPage() {
			if (isFirstPage()) {
				return 1;
			} else {
				return index - 1;
			}
		}

		/**
		 * 获取分页大小
		 * @return 获取分页大小
		 */

		public int getPageSize() {
			return pageSize;
		}

		/**
		 * 设置分页大小
		 * @param pageSize
		 * 
		 */
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
			repaginate();
		}

		/**
		 * 获取当前页。第一页是1
		 */
		public int getIndex() {
			return index;
		}

		/**ethod setIndex sets the index of this PaginatedArrayList object.
		 * 
		 * 设置当前页。第一页是1
		 * 
		 */

		public void setIndex(int index) {
			this.index = index;
			repaginate();
		}

		/**
		 * 总记录数
		 */
		public int getTotalItem() {
			return totalItem;
		}

		/**
		 * 设置总记录数
		 */
		public void setTotalItem(int totalItem) {
			this.totalItem = totalItem;
			if (this.totalItem <= 0) {
				totalPage = 0;
				index = 1;
				startRow = 0;
			}
			repaginate();
		}

		/**
		 * 获取总页数
		 */
		public int getTotalPage() {
			return totalPage;
		}

		/**
		 * 分页后的记录开始的地方
		 */
		public int getStartRow() {
			return (index - 1) * pageSize;
		}

		/**
		 * 分页后的记录结束的地方
		 */
		public int getEndRow() {
			return index * pageSize;
		}

		/**
		 * 计算分页数据
		 */
		public void repaginate() {
			if (pageSize < 1) {                            // 防止程序偷懒，list和分页的混合使用
				pageSize = PAGESIZE_DEFAULT;
			}
			if (index < 1) {
				index = 1;                                  // 恢复到第一页
			}
			if (totalItem > 0) {
				totalPage = totalItem / pageSize
						+ (totalItem % pageSize > 0 ? 1 : 0);// 计算出最大页数
				if (index > totalPage) {                     // 当前页数大于最大页，设置为最大页
					index = totalPage;                       // 最大页
				}
				startRow = (index - 1) * pageSize; // 计算出页开始行数
			}
		}
        
		/***
		 * 获取分表ID
		 * @return
		 */
		public Integer getTableId() {
			return tableId;
		}

		/***
		 * 设置分表ID
		 * @return
		 */
		public void setTableId(Integer tableId) {
			this.tableId = tableId;
		}
       
		/***
		 * 获取排序字段
		 * @return
		 */
		public String getOrderField() {
			return orderField;
		}
       
		/***
		 * 设置排序字段
		 * @return
		 */
		public void setOrderField(String orderField) {
			this.orderField = orderField;
		}

		public Boolean getIsAsc() {
			return isAsc;
		}

		public void setIsAsc(Boolean isAsc) {
			this.isAsc = isAsc;
		}
}
