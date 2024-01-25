package br.com.alexf.boraprofut.features.drawteams

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.koin.androidx.compose.koinViewModel

const val drawTeamsRoute = "drawTeams"

fun NavGraphBuilder.drawTeams(
    onNavigateToRandomTeams: () -> Unit,
    onNavigateToBalancedTeams: () -> Unit,
) {
    composable(drawTeamsRoute) {
        val viewModel = koinViewModel<DrawTeamsViewModel>()
        val uiState by viewModel
            .uiState.collectAsState(initial = DrawTeamsUiState())
        DrawTeamsScreen(
            uiState,
            onDrawRandomTeamsClick = { onNavigateToRandomTeams() },
            onDrawBalancedTeamsClick = { onNavigateToBalancedTeams() }
        )
    }
}

fun NavHostController.navigateToDrawTeams() {
    navigate(drawTeamsRoute)
}