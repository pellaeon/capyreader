package com.capyreader.app.ui.accounts

import com.capyreader.app.common.AppPreferences
import com.jocmp.capy.AccountManager
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class LoginViewModelTest {

    private val accountManager: AccountManager = mockk(relaxed = true)
    private val appPreferences: AppPreferences = mockk(relaxed = true)

    @Test
    fun test_submit_with_empty_credentials_succeeds() {
        val viewModel = LoginViewModel(mockk(), accountManager, appPreferences)
        viewModel.setUsername("")
        viewModel.setPassword("")
        viewModel.setURL("http://example.com")
        viewModel.submit {}
        assert(viewModel.errorMessage == null)
        verify { accountManager.createAccount(any(), any(), any(), any()) }
    }

    @Test
    fun test_submit_with_partial_credentials_succeeds_username() {
        val viewModel = LoginViewModel(mockk(), accountManager, appPreferences)
        viewModel.setUsername("testuser")
        viewModel.setPassword("")
        viewModel.setURL("http://example.com")
        viewModel.submit {}
        assert(viewModel.errorMessage == null)
        verify { accountManager.createAccount(any(), any(), any(), any()) }
    }

    @Test
    fun test_submit_with_partial_credentials_succeeds_password() {
        val viewModel = LoginViewModel(mockk(), accountManager, appPreferences)
        viewModel.setUsername("")
        viewModel.setPassword("testpass")
        viewModel.setURL("http://example.com")
        viewModel.submit {}
        assert(viewModel.errorMessage == null)
        verify { accountManager.createAccount(any(), any(), any(), any()) }
    }

    @Test
    fun test_submit_with_full_credentials_succeeds() {
        val viewModel = LoginViewModel(mockk(), accountManager, appPreferences)
        viewModel.setUsername("testuser")
        viewModel.setPassword("testpass")
        viewModel.setURL("http://example.com")
        viewModel.submit {}
        assert(viewModel.errorMessage == null)
        verify { accountManager.createAccount(any(), any(), any(), any()) }
    }
}