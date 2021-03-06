package org.embulk.formatter.fast_jsonl

import org.embulk.config.{Config, ConfigDefault, Task}
import org.embulk.spi.time.TimestampFormatter
import org.embulk.spi.util.{LineEncoder, Newline}

trait PluginTask
    extends Task
    with LineEncoder.EncoderTask
    with TimestampFormatter.Task {

  @Config("newline")
  @ConfigDefault("\"LF\"")
  def getNewline: Newline

  @Config("explode_json_columns")
  @ConfigDefault("[]")
  def getExplodeJsonColumns(): java.util.List[String]

  @Config("json_columns")
  @ConfigDefault("[]")
  def getJsonColumns(): java.util.List[String]

  @Config("suffix_key")
  @ConfigDefault("{}")
  def getSuffixKey(): java.util.Map[String, String]
}
