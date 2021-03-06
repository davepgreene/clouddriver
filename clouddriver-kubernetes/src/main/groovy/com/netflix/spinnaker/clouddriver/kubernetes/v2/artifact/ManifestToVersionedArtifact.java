/*
 * Copyright 2017 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.netflix.spinnaker.clouddriver.kubernetes.v2.artifact;

import com.netflix.spinnaker.clouddriver.kubernetes.v2.description.KubernetesManifest;
import com.netflix.spinnaker.kork.artifacts.model.Artifact;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class ManifestToVersionedArtifact implements ManifestToArtifact {
  @Override
  public Artifact convert(KubernetesManifest manifest) {
    String type = manifest.getKind().toString();
    String name = manifest.getName();
    String version = RandomStringUtils.randomAlphanumeric(8).toLowerCase(); // TODO(lwander) rely on cache to get proper vNNN number in the future.
    return Artifact.builder()
        .type(type)
        .name(name)
        .version(version)
        .build();
  }
}
