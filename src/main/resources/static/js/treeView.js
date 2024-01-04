function drawTreeView(data) {
  $("#tree-view").bstreeview({
    data,
  })
  // 첫번째 노드를 보여준다.
  $("#tree-view-item-0").addClass("show")
}

function findNodesById(nodes, targetId) {
  for (let i = 0; i < nodes.length; i++) {
    const currentNode = nodes[i]

    if (currentNode.id === targetId) {
      // 특정 id 값을 가진 노드를 찾으면 해당 노드의 nodes 값을 반환
      return currentNode.nodes
    }
    if (currentNode.nodes && currentNode.nodes.length > 0) {
      // 현재 노드에 하위 노드가 있다면 재귀적으로 검색
      const nestedNodes = findNodesById(currentNode.nodes, targetId)
      if (nestedNodes) {
        return nestedNodes // 하위 노드에서 찾았으면 반환
      }
    }
  }

  // 해당 id를 찾지 못했을 경우
  return null
}

function addCheckAllEvent() {
  // set checkbox event
  $("#checkAll").click(() => {
    if ($("#checkAll").is(":checked")) {
      $("input[name=tree-body]").prop("checked", true)
    } else {
      $("input[name=tree-body]").prop("checked", false)
    }
  })

  $("input[name=tree-body]").click(() => {
    if (
      $("input[name=tree-body]:checked").length ===
      $("input[name=tree-body]").length
    ) {
      $("#checkAll").prop("checked", true)
    } else {
      $("#checkAll").prop("checked", false)
    }
  })
}

function addCheckEvent(checkedUserIds) {
  $("input[name=tree-body]").change(function () {
    const userIdElement = $(this).parent().parent().find('td[class="userId"]')
    const checked = $(this).is(":checked")

    if (checked) {
      // 체크된 table의 row 값 가져오기
      const checkedUserId = userIdElement.text()
      checkedUserIds.push(checkedUserId)
    } else {
      const userIdToRemove = userIdElement.text()
      const index = checkedUserIds.indexOf(userIdToRemove)

      if (index !== -1) {
        checkedUserIds.splice(index, 1)
      }
    }

    console.log(checkedUserIds)
  })
}

function loadUserData(targetId) {
  $.ajax({
    url: `/api/users/${targetId}`,
    type: "GET",
    dataType: "json",
  })
    .done((data) => {
      // table 비우기
      $("#dataTable thead").empty()
      $("#dataTable thead").append(
        "<th>" +
          '<input type="checkbox" id="checkAll"/>' +
          "</th>" +
          "<th>조직ID</th>" +
          "<th>유저ID</th>" +
          "<th>Name</th>" +
          "<th>e-mail</th>" +
          "<th>생성일</th>",
      )

      $("#dataTable tbody").empty()
      // table 채우기
      for (let i = 0; i < data.length; i++) {
        const user = data[i]
        $("#dataTable tbody").append(
          "<tr>" +
            '<td><input type="checkbox" name="tree-body"></td>' +
            `<td class='organizationId'>${user.organizationId}</td>` +
            `<td class='userId'>${user.id}</td>` +
            `<td class='username'>${user.username}</td>` +
            `<td class='email'>${user.email}</td>` +
            `<td class='createdAt'>${user.createdAt}</td>` +
            "</tr>",
        )
      }

      const checkedUserIds = []

      addCheckAllEvent()
      addCheckEvent(checkedUserIds)
    })
    .fail(() => {
      alert("User Data Error!")
    })
}

function addGroupClickEvent(data) {
  $(".list-group-item").on("click", function () {
    const nodes = findNodesById(data, this.id)
    if (nodes === null) {
      loadUserData(this.id)
    }
  })
}

function initializeTreeView() {
  $.ajax({
    url: "/api/tree/1",
    type: "GET",
    dataType: "json",
  })
    .done((data) => {
      drawTreeView(data)
      addGroupClickEvent(data)
    })
    .fail(() => {
      alert("Tree Data Error!")
    })
}

$(document).ready(() => {
  initializeTreeView()
})
