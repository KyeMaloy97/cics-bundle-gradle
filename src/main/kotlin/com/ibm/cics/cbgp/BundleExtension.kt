package com.ibm.cics.cbgp

import org.gradle.api.Action
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.create

open class BundleExtension(private val dh: DependencyHandler) {

	val build: BundleBuildExtension = BundleBuildExtension()
	val deploy: BundleDeployExtension = BundleDeployExtension()

	fun build(action: Action<in BundleBuildExtension>) {
		action.execute(build)
	}

	fun deploy(action: Action<in BundleDeployExtension>) {
		action.execute(deploy)
	}

	fun osgi(group: String, name: String, version: String? = null, classifier: String? = null, ext: String? = "jar", versionRange: String? = null) {
		val dep = dh.create(group, name, version, null, classifier, ext)
		dh.add("cicsBundlePart", dep)
	}
}