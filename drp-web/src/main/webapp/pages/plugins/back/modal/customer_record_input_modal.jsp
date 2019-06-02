<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="customerRecordInputInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1300px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;追加客户联系记录</strong></h3>
				</div>
			</div>
			<div class="modal-body">
				<div id="customerRecordInfo">
					<form class="form-horizontal" action="/pages/back/admin/customer/customer_record_input.action" id="myform" method="post">
						<fieldset>
							<input type="hidden" id="cuid" name="cuid">
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="titleDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="title">联系目的：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="title" name="title" class="form-control"
										placeholder="请输入本次联系的主题名称">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="titleMsg"></div>
							</div>
							<div class="form-group" id="criidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="criid">业务分类：</label>
								<div class="col-md-5">
									<select id="criid" name="criid" class="form-control">
										<option value="">====== 请选择联系的业务类型 ======</option>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="criidMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="note">备注信息：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<textarea id="note" name="note"
										class="form-control" placeholder="请输入本次联系的相关事宜" rows="10"></textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="noteMsg"></div>
							</div>
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary">增加</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
				<div id="pageDiv" class="text-right">
					<ul class="pagination pagination-sm" id="pagecontrol"></ul>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
			</div>
		</div>
	</div>
</div>
