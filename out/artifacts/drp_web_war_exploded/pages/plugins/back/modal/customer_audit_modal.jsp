<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="customerAuditInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;客户入驻申请</strong></h3>
				</div>
			</div>
			<div class="modal-body">
				<div>
					<form class="form-horizontal" action="" id="auditform" method="post">
						<fieldset>
							<div class="form-group" id="auditDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="audit">出库省份：</label>
								<div class="col-md-5">
									<select id="audit" name="audit" class="form-control">
										<option value="">====== 请选择审核结果 ======</option>
										<option value="1">通过</option>
										<option value="2">拒绝</option>
										<option value="3">修改</option>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="auditMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="note">审核说明：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<textarea id="note" name="note"
											  class="form-control" placeholder="请输入本次审核的相关信息" rows="10"></textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="noteMsg"></div>
							</div>
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary">提交</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
			</div>
		</div>
	</div>
</div>
