/*
 * Copyright 2017 Volodymyr Fedorchuk <vl.fedorchuck@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.fedorchuck.dnjson.exceptions;

/**
 * Instances of this Exception are thrown if failed to decode a JSON string, because of invalid JSON.
 *
 * <p> <b>Author</b>: <a href="https://vl-fedorchuck.firebaseapp.com/">Volodymyr Fedorchuk</a> </p>
 * @author <a href="https://vl-fedorchuck.firebaseapp.com/">Volodymyr Fedorchuk</a>
 * @since 0.1.0
 */
public class JsonProcessingException extends RuntimeException {

  public JsonProcessingException(String message, Throwable cause) {
    super(message, cause);
  }

  public JsonProcessingException(String message) {
    super(message);
  }
}
