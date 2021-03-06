/*
 * Copyright 2014 Baptiste Chatrain <baptiste.chatrain@gmail.com>
 *
 * This file is part of Gradle Git-Dependencies Plugin.
 *
 * Gradle Git-Dependencies Plugin is free software:
 * you can redistribute it and/or modifyit under the terms of the GNU General
 * Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * Gradle Git-Dependencies Plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Gradle Git-Dependencies Plugin.
 * If not, see <http://www.gnu.org/licenses/>.
 */
package org.batcha.gradle.plugins

import org.batcha.gradle.plugins.git.InitGitDependenciesTask
import org.batcha.gradle.plugins.git.RefreshGitDependenciesTask
import org.batcha.gradle.plugins.git.ResolveGitDependenciesTask
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Git-Dependencies Plugin implementation.
 * @author bat-cha
 *
 */
class GitDependenciesPlugin implements Plugin<Project> {

  /**
   * Plugin application.
   */
  def void apply( Project project) {

    project.convention.plugins.gitDependencies = new GitDependenciesConvention(project)

    project.task('initGitDependencies', type: InitGitDependenciesTask)
    project.task('resolveGitDependencies', type: ResolveGitDependenciesTask)
    project.task('refreshGitDependencies', type: RefreshGitDependenciesTask)



    project.afterEvaluate {

      project.tasks.resolveGitDependencies.execute()
    }
  }
}
