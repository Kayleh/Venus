package com.venus.framework.security.handle;

import com.venus.common.constant.Constants;
import com.venus.common.core.domain.AjaxResult;
import com.venus.common.core.domain.model.LoginUser;
import com.venus.common.utils.JsonUtil;
import com.venus.common.utils.MessageUtils;
import com.venus.common.utils.ServletUtils;
import com.venus.common.utils.StringUtils;
import com.venus.framework.manager.AsyncManager;
import com.venus.framework.manager.factory.AsyncFactory;
import com.venus.framework.web.service.TokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;

/**
 * 自定义退出处理类 返回成功
 *
 * @author venus
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {
    @Autowired
    private TokenService tokenService;

    /**
     * 退出处理
     *
     * @return
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser)) {
            String userName = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // 记录用户退出日志
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGOUT, MessageUtils.message("user.logout.success")));
        }
        ServletUtils.renderString(response, JsonUtil.toJson(AjaxResult.success(MessageUtils.message("user.logout.success"))));
    }
}
