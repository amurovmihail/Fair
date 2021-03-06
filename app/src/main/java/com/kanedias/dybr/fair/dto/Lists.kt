package com.kanedias.dybr.fair.dto

import com.squareup.moshi.Json
import moe.banana.jsonapi2.*

/**
 * Action list creation request
 * Example:
 * ```
 * {
 *   "data": {
 *     "type": "lists",
 *     "attributes": {
 *       "action": "hide",
 *       "scope": "feed",
 *       "kind": "profile"
 *       "name": "for persistent abuse"
 *     },
 *     "relationships": {
 *       "profiles": {
 *         "data": [
 *           {
 *             "id": "19662",
 *             "type": "profiles"
 *           }
 *         ]
 *       }
 *     }
 *   }
 * }
 *
 * ```
 *
 * @author Kanedias
 *
 * Created on 15.12.19
 */
@JsonApi(type = "profile-list", policy = Policy.SERIALIZATION_ONLY)
class ActionListRequest: Resource() {

    /**
     * Action that should be performed on the target
     */
    @Json(name = "action")
    var action = "hide"

    /**
     * Scope of the action
     */
    @Json(name = "scope")
    lateinit var scope: String

    /**
     * Type of the target
     */
    @Json(name = "kind")
    var kind = "profile"

    /**
     * Reason for creating this list item
     */
    @Json(name = "name")
    var name: String = ""

    /**
     * Target profiles
     */
    @Json(name = "profiles")
    val profiles = HasMany<OwnProfile>()
}

/**
 * Basic list item, with scope and action
 * Example:
 * ```
 * {
 *     "type": "profile-list"
 *     "id": "218",
 *     "attributes": {
 *         "action": "hide",
 *         "kind": "profile",
 *         "name": "",
 *         "scope": "feed"
 *     },
 *     "relationships": {
 *         "profiles": {
 *             "data": [
 *                 {
 *                     "id": "1250",
 *                     "type": "profiles"
 *                 },
 *                 {
 *                     "id": "19662",
 *                     "type": "profiles"
 *                 }
 *             ]
 *         }
 *     },
 * }
 * ```
 *
 * @author Kanedias
 *
 * Created on 15.12.19
 */
@JsonApi(type = "profile-list", policy = Policy.DESERIALIZATION_ONLY)
class ActionListResponse: Resource() {
    /**
     * Type of list action to perform
     */
    @Json(name = "action")
    lateinit var action: String

    /**
     * Type of entity that this action affects
     */
    @Json(name = "kind")
    lateinit var kind: String

    /**
     * Scope of the action
     */
    @Json(name = "scope")
    lateinit var scope: String

    /**
     * Name of this list item
     */
    @Json(name = "name")
    lateinit var name: String

    /**
     * Profile that this action affects
     */
    @Json(name = "profiles")
    var profiles = HasMany<OwnProfile>()
}

typealias ActionList = ActionListResponse